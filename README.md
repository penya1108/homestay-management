# Hệ thống quản lý Homestay

Bản khởi tạo mã nguồn theo đề tài trong báo cáo: **Xây dựng hệ thống quản lý Homestay**.

## Công nghệ
- Backend: Java 17, Spring Boot 3.2.0, Spring Web, Spring Data JPA, Bean Validation
- Database: PostgreSQL
- Frontend: Angular + TypeScript (khởi tạo bằng Angular CLI)
- API docs: Springdoc OpenAPI

> Đây là bộ mã nguồn nền tảng có thể chạy và mở rộng. Các luồng nghiệp vụ nâng cao như JWT/RBAC hoàn chỉnh, quét QR CCCD, xuất hóa đơn PDF và báo cáo doanh thu cần được hoàn thiện/kiểm thử tiếp trước khi dùng thực tế.

## 1. Yêu cầu
- JDK 17+
- Maven 3.9+
- PostgreSQL 15+
- Node.js LTS và npm
- Angular CLI tương thích với phiên bản Angular bạn cài

## 2. Tạo cơ sở dữ liệu
Trong PostgreSQL tạo database `homestay_db`, sau đó chạy file `database/schema.sql`.

Tài khoản database mặc định trong cấu hình là `postgres`; hãy đổi mật khẩu trong `backend/src/main/resources/application.properties` theo máy của bạn.

## 3. Chạy Backend
```bash
cd backend
mvn spring-boot:run
```
Backend mặc định: `http://localhost:8080`
Swagger UI: `http://localhost:8080/swagger-ui.html`

## 4. Tạo và chạy Frontend Angular
Trong thư mục gốc:
```bash
npm install -g @angular/cli
ng new frontend --routing --style=css
```
Khi Angular CLI hỏi, chọn các thiết lập mặc định. Sau đó thay nội dung `frontend/src/app/app.component.ts` và `frontend/src/app/app.component.html` bằng các file mẫu ở `frontend-template/` (đổi tên thành `app.component.*`), rồi chạy:
```bash
cd frontend
npm install
ng serve
```
Frontend gọi API ở `http://localhost:8080/api`.

## 5. API hiện có
- `GET/POST /api/customers`
- `GET/PUT/DELETE /api/customers/{id}`
- `GET/POST /api/room-types`
- `GET/PUT/DELETE /api/room-types/{id}`
- `GET/POST /api/rooms`
- `GET/PUT/DELETE /api/rooms/{id}`
- `GET/POST /api/services`
- `GET/PUT/DELETE /api/services/{id}`
- `GET/POST /api/vouchers`
- `GET/PUT/DELETE /api/vouchers/{id}`
- `GET/POST /api/bookings`
- `GET/PUT/DELETE /api/bookings/{id}`

Lưu ý: DELETE hiện là xóa mềm cho các thực thể kế thừa BaseEntity.

## 6. Giới hạn của bản nền tảng
- Chưa tích hợp đăng nhập JWT/RBAC hoàn chỉnh; không đưa lên Internet hoặc dùng với dữ liệu thật trước khi bổ sung bảo mật.
- Luồng check-in/check-out, kiểm tra trùng lịch đặt phòng, ghi nhận dịch vụ, tính hóa đơn và xuất PDF chưa được triển khai đầy đủ trong bản này.
- Giao diện hiện có CRUD thực tế cho khách hàng; các phân hệ khác đang có màn hình danh sách và cần bổ sung form CRUD.
- Cần chạy thử trên máy của bạn, điều chỉnh cấu hình PostgreSQL và xử lý lỗi phát sinh theo môi trường cài đặt.
