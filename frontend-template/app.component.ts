import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HttpClient, HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';

type Customer = {
  id?: number; fullName: string; identityNumber?: string; phone?: string;
  email?: string; membershipLevel?: string; loyaltyPoints?: number;
};

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [CommonModule, HttpClientModule, FormsModule],
  templateUrl: './app.component.html'
})
export class AppComponent implements OnInit {
  title = 'Homestay Manager';
  active = 'dashboard';
  customers: Customer[] = [];
  rooms: any[] = [];
  roomTypes: any[] = [];
  services: any[] = [];
  bookings: any[] = [];
  vouchers: any[] = [];
  loading = false;
  error = '';
  message = '';
  search = '';
  showCustomerForm = false;
  editingId?: number;
  customer: Customer = this.emptyCustomer();

  private api = 'http://localhost:8080/api';

  constructor(private http: HttpClient) {}

  ngOnInit(): void { this.loadCurrent(); }

  setPage(page: string): void {
    this.active = page;
    this.error = '';
    this.message = '';
    this.loadCurrent();
  }

  loadCurrent(): void {
    const routes: Record<string, string> = {
      customers: 'customers', rooms: 'rooms', roomTypes: 'room-types',
      services: 'services', bookings: 'bookings', vouchers: 'vouchers'
    };
    const route = routes[this.active];
    if (!route) return;
    this.loading = true;
    this.http.get<any[]>(`${this.api}/${route}`).subscribe({
      next: data => {
        if (this.active === 'customers') this.customers = data;
        if (this.active === 'rooms') this.rooms = data;
        if (this.active === 'roomTypes') this.roomTypes = data;
        if (this.active === 'services') this.services = data;
        if (this.active === 'bookings') this.bookings = data;
        if (this.active === 'vouchers') this.vouchers = data;
        this.loading = false;
      },
      error: () => { this.error = 'Không thể kết nối API. Hãy kiểm tra Backend và PostgreSQL.'; this.loading = false; }
    });
  }

  get filteredCustomers(): Customer[] {
    const q = this.search.trim().toLowerCase();
    return this.customers.filter(c => `${c.fullName} ${c.identityNumber ?? ''} ${c.phone ?? ''}`.toLowerCase().includes(q));
  }

  emptyCustomer(): Customer { return { fullName: '', identityNumber: '', phone: '', email: '', membershipLevel: 'STANDARD', loyaltyPoints: 0 }; }

  openCreateCustomer(): void {
    this.editingId = undefined; this.customer = this.emptyCustomer(); this.showCustomerForm = true;
  }

  openEditCustomer(c: Customer): void {
    this.editingId = c.id; this.customer = { ...c }; this.showCustomerForm = true;
  }

  saveCustomer(): void {
    if (!this.customer.fullName.trim()) { this.error = 'Vui lòng nhập họ tên khách hàng.'; return; }
    const req = this.editingId
      ? this.http.put(`${this.api}/customers/${this.editingId}`, this.customer)
      : this.http.post(`${this.api}/customers`, this.customer);
    req.subscribe({
      next: () => { this.showCustomerForm = false; this.message = 'Đã lưu khách hàng.'; this.loadCurrent(); },
      error: e => { this.error = e?.error?.message || 'Lưu dữ liệu thất bại. Kiểm tra thông tin nhập.'; }
    });
  }

  deleteCustomer(c: Customer): void {
    if (!c.id || !confirm(`Ngừng hoạt động khách hàng "${c.fullName}"?`)) return;
    this.http.delete(`${this.api}/customers/${c.id}`).subscribe({
      next: () => { this.message = 'Đã ngừng hoạt động khách hàng.'; this.loadCurrent(); },
      error: () => this.error = 'Không thể xóa khách hàng.'
    });
  }

  trackById(_: number, item: any): number { return item.id; }
}
