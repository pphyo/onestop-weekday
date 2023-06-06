import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environment/environment';

const API = `${environment.baseApi}/accounts`

@Injectable({
  providedIn: 'root'
})
export class AccountsService {

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

  private update(id:number, form:any) {
    return this.http.put<any>(`${API}/${id}`, form)
  }

  search() {
    return this.http.get<any[]>(API)
  }

  getTotalBalance() {
    return this.http.get<number>(`${API}/total`)
  }

  remove(id:number) {
    return this.http.delete<any>(`${API}/${id}`)
  }

}
