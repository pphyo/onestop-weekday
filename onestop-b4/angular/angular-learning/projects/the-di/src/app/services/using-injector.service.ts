import { Injectable } from "@angular/core";

@Injectable({
  providedIn: 'root'
})
export class InjectorService {

  private _list = [
    {id: 1, name: 'Angela', role: 'Support', fav: false},
    {id: 2, name: 'Mellisa', role: 'Marksman', fav: true},
    {id: 3, name: 'Franco', role: 'Tank/Support', fav: true},
    {id: 4, name: 'Arlott', role: 'Fighter/Assasin', fav: true},
    {id: 5, name: 'Nana', role: 'Mage/Support', fav: false}
  ]

  save(hero:any) {
    this._list.push(hero);
  }

  findById(id:number) {
    return this._list.find(h => h.id == id)
  }

  getAll() {
    return this._list;
  }

}
