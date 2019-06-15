# Create Yourself - Human 2.0 Experiment

TODO:
+ Wyliczanie progresu i kolorowanie
+ Dodawanie foto
- Planer msc
+ daty: sortowanie kolorowanie
- css fix
- refresh fix
- deploy


- CSS fixy


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

### Celebration:
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
  
## Daty

- [ ] lista
- [ ] dodowanie
- [ ] usuwanie

---

20/11/2018:
- [x] Dodanie do menu: "Daty"

21/11/2018:
Daty:
- [ ] Dodanie komponentu
- [ ] Repo
- [ ] Service
- [ ] GUI - lista
- [ ] Usuwanie z listy



https://grokonez.com/spring-framework/spring-data/spring-boot-angular-6-example-spring-data-rest-mongodb-crud-example

https://developer.okta.com/blog/2018/08/22/basic-crud-angular-7-and-spring-boot-2
