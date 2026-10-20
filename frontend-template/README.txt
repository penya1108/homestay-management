Sau khi tạo Angular app bằng `ng new frontend --routing --style=css`:
1. Chép `app.component.ts` vào `frontend/src/app/app.component.ts`
2. Chép `app.component.html` vào `frontend/src/app/app.component.html`
3. Chép `styles.css` vào `frontend/src/styles.css`
4. Đảm bảo `src/main.ts` bootstrap standalone AppComponent (Angular CLI mặc định đã có).
5. Trong `src/app/app.config.ts`, thêm provideHttpClient() vào providers:
   import { provideHttpClient } from '@angular/common/http';
   providers: [provideHttpClient(), ...]
6. Xóa HttpClientModule khỏi imports của component nếu dùng provideHttpClient (có thể giữ HttpClientModule để chạy bản mẫu tùy cấu hình).
