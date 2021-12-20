#Use cases

### Create new client

POST /clients/crear

```mermaid
sequenceDiagram
participant U as User
participant C as ClientController
participant S as ClientService
participant R as ClientRepository
participant D as Database

U->>C: POST /clientes/crear
C->>C: Check username
C->>S: Send client info
S->>R: Validate client info
alt valid_user
    R->>D: Save client
    D->>R: Return result
    R->>S: Return result
    S->>C: Return result 
    C-->>U: (201) Return client save

else username_invalid_fields
    R->>S: Return error
    S->>C: Return error 
    C->>U: (400) Bad Request
end
```

### Delete exist client
DELETE /clientes/eliminar?username=[username]

```mermaid
sequenceDiagram
participant U as User
participant C as ClientController
participant S as ClientService
participant R as ClientRepository
participant D as Database

U->>C: DELETE /clientes/eliminar?username=[username]
C->>C: Check username
C->>S: Send client username
alt valid_user
    S->>R: Send client username
    alt is_authorized
        R->>D: Delete client
        D->>R: Return result
        R->>S: Return result
        S->>C: Return result 
        C-->>U: (200) Confirm delete operation
    else user_not_authorized
        R->>S: Return error
        S->>C: Return error 
        C->>U: (401) Unauthorized
    end
else client_not_found
    R->>S: Return error
    S->>C: Return error 
    C->>U: (400) Bad Request
end
```

### Update exists client
PUT /clientes/actualizar

```mermaid
participant U as User
participant C as ClientController
participant S as ClientService
participant R as ClientRepository
participant D as Database

U->>C: PUT /clientes/actualizar
C->>C: Check username
C->>S: Send client info
alt valid_user
    S->>R: Send client info
    alt is_authorized
        R->>D: Update client
        D->>R: Return result
        R->>S: Return result
        S->>C: Return result 
        C-->>U: (200) Confirm update operation
    else user_not_authorized
        R->>S: Return error
        S->>C: Return error 
        C->>U: (401) Unauthorized
    end
else client_not_found
    R->>S: Return error
    S->>C: Return error 
    C->>U: (400) Bad Request
end
```

### Search specific client
GET clientes/buscar?username=xxxxxx

```mermaid
sequenceDiagram
participant U as User
participant C as ClientController
participant S as ClientService
participant R as ClientRepository
participant D as Database

U->>C: GET /clientes/buscar?username=[username]
C->>C: Check username
C->>S: Send client username
alt valid_user
    S->>R: Send client username
    alt is_authorized
        R->>D: Update client
        D->>R: Return result
        R->>S: Return result
        S->>C: Return result 
        C-->>U: (200) Return client info
    else user_not_authorized
        R->>S: Return error
        S->>C: Return error 
        C->>U: (401) Unauthorized
    end
else client_not_found
    R->>S: Return error
    S->>C: Return error 
    C->>U: (204) No content
end
```

### List all exists clients
GET /clientes/listar

```mermaid
sequenceDiagram
participant U as User
participant C as ClientController
participant S as ClientService
participant R as ClientRepository
participant D as Database

U->>C: GET /clientes/listar
C->>C: Check username
C->>S: Send client username
alt valid_user
    S->>R: Get all clients info
    alt is_authorized
        R->>D: List all exists clients
        D->>R: Return result
        R->>S: Return result
        S->>C: Return result 
        C-->>U: (200) Return client list
    else user_not_authorized
        R->>S: Return error
        S->>C: Return error 
        C->>U: (401) Unauthorized
    end
else not_exists_clients
    R->>S: Return response
    S->>C: Return response 
    C->>U: (204) No content
end
```