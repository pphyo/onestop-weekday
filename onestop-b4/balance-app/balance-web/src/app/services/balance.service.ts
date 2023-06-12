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
    const {id, ...formData} = form
    if(id)
      return this.update(id, form)
    return this.create(form)
  }

  private create(form:any) {
    return this.http.post<any>(API, form)
  }

  private update(id:any, form:any) {
    return this.http.put<any>(`${API}/${id}`, form)
  }

  searchInSpecificMonth(date:Date) {
    return this.http.get<any>(`${API}/${date.toISOString().slice(0, 10)}`)
  }

  getExpenseAmount(type:string) {
    return this.http.get<any>(`${API}/type/${type}`)
  }

  remove(id:number) {
    return this.http.delete<any>(`${API}/${id}`)
  }
}
