# Create Yourself - Human 2.0 Experiment

Dev:
- Spring Boot
- H2 Database
- Spring Data JPA
- Spring Data REST
- Spring MVC
- Project Lombok
- Maven
- GIT
- Angular 

## Entitites:

### Category:
- name: String 
- description: String
- icon: byte[]
- List<objectives>
  
### Objective:
- name:String
- description: String
- category: Category
- date: date/LocalDate
- photo: byte[]
- importence: Enum
- List<Todo>
  
### Todo:
- name: String
- isDone: boolean
- date: date/localDate

### Dates:
- date: Date
- description: String


## API:

\categories
\categories\{id}

\categories\{id}\objectives
\categories\{id}\objectives\{id}


## Menu:
- Statystyki
- Cele
- Kategorie
- Daty

## Ekrany:

### Statystyki
Wszystkie: {} Wykonane: {} Pozostałe: {}

### Cele
- [ ] Lista
- [ ] filtrowanie (kategoria, data, nazwa)
- [ ] dodawanie

### Kategorie

- [ ] Lista
- [ ] edycja
- [ ] dodawanie


