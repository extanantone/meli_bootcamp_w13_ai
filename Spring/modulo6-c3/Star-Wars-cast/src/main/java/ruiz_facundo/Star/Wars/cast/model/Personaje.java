package ruiz_facundo.Star.Wars.cast.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Personaje {
    private String name;
    private Integer height;
    private Integer mass;
    private String hairColor;
    private String skinColor;
    private String eyeColor;
    private String birthYear;
    private String gender;
    private String homeworld;
    private String species;

    public Personaje(String inName, Integer inHeight,
                     Integer inMass, String inHairColor,
                     String inSkinColor, String inEyeColor,
                     String inBirthYear, String inGender,
                     String inHomeworld, String inSpecies) {
        this.name = inName;
        this.height = inHeight;
        this.mass = inMass;
        this.hairColor = inHairColor;
        this.skinColor = inSkinColor;
        this.eyeColor = inEyeColor;
        this.birthYear = inBirthYear;
        this.gender = inGender;
        this.homeworld = inHomeworld;
        this.species = inSpecies;
    }
}
