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
- [ ] Statystyki
- [ ] Cele
- [ ] Kategorie
- [ ] Daty

## Ekrany:

### Statystyki
- [ ] Wszystkie: {} Wykonane: {} Pozostałe: {}
- [ ] Wykres
- [ ] Planner (Miesiac - kategoria - Todos)

### Cele
- [ ] lista
- [ ] filtrowanie (kategoria, data, nazwa)
- [ ] dodawanie
- [ ] edycja

### Kategorie

- [ ] lista
- [ ] edycja
- [ ] dodawanie
  


20/11/2018:
- [x] Dodanie do menu: "Daty"

21/11/2018:
Daty:
- [ ] Dodanie komponentu
- [ ] Repo
- [ ] Service
- [ ] GUI - lista
- [ ] Usuwanie z listy


