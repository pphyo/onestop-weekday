import { Injectable } from "@angular/core";
import { HttpClient } from "@angular/common/http"
import { environment } from "src/environment/environment";

const API = `${environment.baseApi}/categories`

@Injectable({
  providedIn: 'root'
})
export class CategoryService {

  constructor(private http:HttpClient) {}

  save(form:any) {
    return this.http.post<any>(API, form)
  }

  find(form:any) {
    return this.http.get<any>(API, {params: form})
  }

  remove(id:any) {
    return this.http.delete<any>(`${API}/${id}`)
  }

}
