import { Component, EventEmitter, Input, Output } from '@angular/core';
import { CommonModule } from '@angular/common';
import { NoDataComponent } from '../../no-data/no-data.component';

@Component({
  selector: 'app-category-list',
  standalone: true,
  imports: [CommonModule, NoDataComponent],
  templateUrl: './category-list.component.html'
})
export class CategoryListComponent {

  @Input()
  list:any

  @Output()
  onEdit = new EventEmitter<number>

  @Output()
  onRemove = new EventEmitter<number>

  edit(id:number) {
    this.onEdit.emit(id)
  }

  remove(id:number) {
    this.onRemove.emit(id)
  }

}
