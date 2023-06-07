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

    const{id, ...formData} = form
    if(id)
      return this.edit(id, formData)

    return this.create(form)
  }

  private create(form: any) {
    return this.http.post<any>(API, form)
  }

  private edit(id:number, form:any) {
    return this.http.put<any>(`${API}/${id}`, form)
  }

  findById(id:number) {
    return this.http.get<any>(`${API}/${id}`)
  }

  findByType(type:string) {
    return this.http.get<any[]>(`${API}/type/${type}`)
  }

  find(form:any) {
    return this.http.get<any[]>(API, {params: form})
  }

  remove(id:any) {
    return this.http.delete<any>(`${API}/${id}`)
  }

  upload(file:any) {
    const formData = new FormData
    formData.append('file', file, file.name)
    return this.http.post<any[]>(`${API}/upload`, formData)
  }

}
