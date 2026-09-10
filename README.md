# Gem & Jewellery Management System — REST API

Coursework project for **ITS1144 – Advanced API Development**.
Built with the same stack/pattern shown in the lecturer's `spring-security-test`
example project (Spring Boot + Spring Security + JWT + Spring Data JPA + MySQL),
extended to the Gem & Jewellery Management System use case / ER diagram.

## Tech stack
- Spring Boot 3.3.4, Java 17
- Spring Security + JWT (`jjwt` 0.11.5) — same pattern as the lecturer's project
- Spring Data JPA / Hibernate + MySQL
- Lombok
- SLF4J + Logback (console + rolling file under `logs/`)
- Frontend: **one single HTML page** (`src/main/resources/static/index.html`)
  using jQuery + AJAX (no build step, no separate frontend framework),
  same jQuery CDN and `$.ajax` style as the lecturer's `Login.html` / `UserManagement.html`.

## Database (15 tables)
`roles, users, customers, suppliers, gem_types, gem_colors, gem_origins,
gemstones, gem_certificates, gem_valuations, gem_inventory,
jewellery_categories, jewellery_items, orders, order_items`

Matches the ER diagram / use case diagram you drew (admin, staff, customer actors).

## How to run
1. Install MySQL and make sure it's running on `localhost:3306`.
2. Edit `src/main/resources/application.properties` if your MySQL username/password
   are different from `root` / `Root@123`. The database `gem_jewellery_db` is created
   automatically (`createDatabaseIfNotExist=true`).
3. Run:
   ```
   ./mvnw spring-boot:run
   ```
   (or open the project in IntelliJ and run `GemJewelleryApplication`)
4. Open **http://localhost:8080/** — the whole frontend loads on that one page.

On first run the app seeds:
- 3 roles: `ADMIN`, `STAFF`, `CUSTOMER`
- 1 default admin login → **username: `admin`, password: `admin123`**

## How the roles work (use case diagram)
- **Guest** → can browse the jewellery catalogue without logging in
  (`GET /v1/jewellery-items`, `/v1/gem-types`, `/v1/gem-colors`, `/v1/gem-origins`, `/v1/categories`)
  and can self-register a customer account (`POST /v1/auth/register-customer`).
- **Customer** → logs in, can place orders and see their own order history.
- **Staff** → logs in, manages gemstones, jewellery items, suppliers, reference
  data, customers, and processes (updates the status of) orders.
- **Admin** → everything staff can do, plus deleting records and creating new
  staff/admin accounts (`POST /v1/auth/register-staff`).

All of this is enforced in `security/SecurityConfig.java` with
`hasRole(...)` / `hasAnyRole(...)`, not just hidden in the UI.

## What's deliberately kept simple
Per your request to cut the complexity down: the reference/lookup tables
(gem types, colors, origins, categories, suppliers) go straight from
controller → repository with no extra service layer, since there's no real
business logic in a plain lookup CRUD. Business logic that actually matters
(login/JWT issuing, placing an order → checking stock → decrementing stock →
computing the total) still goes through a proper `service` layer, same
pattern as the lecturer's `UserService`/`UserServiceImpl`.

The `GemCertificate`, `GemValuation` and `GemInventory` tables/endpoints exist
and work (so you still have your 15 normalized tables + full CRUD backend),
but they are not wired into the single-page UI to keep the frontend
readable — wire them up the same way the Gemstone form does if you want
to show/demo them too.

## No AI part
As requested, the "bonus: AI integration" idea from the brief was left out entirely.

## Still on you
- Git commit history (make small, meaningful commits as you build on this).
- The actual Project Report / documentation write-up for submission.
- Swagger/OpenAPI docs if you want to add them (not included, keeps things simple).
- Testing the full flow yourself end-to-end against your MySQL instance —
  this was written and reviewed carefully but not compiled/run in this
  environment (no internet access to Maven Central here), so build it once
  locally before you rely on it.
