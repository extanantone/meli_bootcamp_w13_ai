package com.mercadolibre.sportsclub.repository.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mercadolibre.sportsclub.exception.MemberNotFoundException;
import com.mercadolibre.sportsclub.model.MemberDTO;
import com.mercadolibre.sportsclub.repository.MemberDAO;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashSet;
import java.util.Properties;
import java.util.Set;

@Repository
public class MemberDAOImpl implements MemberDAO {

    private String SCOPE;

    private Set<MemberDTO> members;

    public MemberDAOImpl() {
        Properties properties = new Properties();

        try {
            properties.load(new ClassPathResource("application.properties").getInputStream());
            this.SCOPE = properties.getProperty("api.scope");
            this.loadData();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public MemberDTO findById(Long memberId) {
        loadData();
        return members.stream()
                .filter(member -> member.getId().equals(memberId))
                .findFirst().orElseThrow(() -> new MemberNotFoundException(memberId));
    }

    @Override
    public void save(MemberDTO member) {
        boolean removed = this.delete(member.getId());

        if (!removed) member.setId((this.members.size() + 1L));

        members.add(member);

        this.saveData();
    }

    @Override
    public boolean delete(Long memberId) {
        boolean removed = false;

        try {
            MemberDTO found = this.findById(memberId);

            members.remove(found);
            removed = true;
            this.saveData();

        } catch (MemberNotFoundException ex) {
            ex.printStackTrace();
        }

        return removed;
    }

    public boolean exists(MemberDTO member) {
        boolean ret = false;

        try {
            ret = this.findById(member.getId()) != null;
        } catch (MemberNotFoundException ex) {
            ex.printStackTrace();
        }

        return ret;
    }

    private void loadData() {
        Set<MemberDTO> loadedData = new HashSet<>();

        ObjectMapper objectMapper = new ObjectMapper();
        File file;
        try {
            file = ResourceUtils.getFile("./src/" + SCOPE + "/resources/members.json");
            loadedData = objectMapper.readValue(file, new TypeReference<Set<MemberDTO>>() {
            });
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Failed while initializing DB, check your resources files");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Failed while initializing DB, check your JSON formatting.");
        }

        this.members = loadedData;
    }

    private void saveData() {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            File file = ResourceUtils.getFile("./src/" + SCOPE + "/resources/members.json");
            objectMapper.writeValue(file, this.members);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Failed while writing to DB, check your resources files");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Failed while writing to DB, check your JSON formatting.");
        }
    }
}
