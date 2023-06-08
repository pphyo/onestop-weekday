import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environment/environment';

const API = `${environment.baseApi}/balances`

@Injectable({
  providedIn: 'root'
})
export class BalanceService {

  constructor(private http:HttpClient) { }

  save(form:any) {
    return this.http.post<any>(API, form)
  }

  searchInSpecificMonth(date:Date) {
    return this.http.get<any>(`${API}/${date.toISOString().slice(0, 10)}`)
  }

  getExpenseAmount(type:string) {
    return this.http.get<any>(`${API}/type/${type}`)
  }
}
