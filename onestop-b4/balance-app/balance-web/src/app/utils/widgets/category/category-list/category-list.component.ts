import { Component, EventEmitter, Input, Output } from '@angular/core';
import { CommonModule } from '@angular/common';
import { NoDataComponent } from '../../no-data/no-data.component';
import { RouterModule } from '@angular/router';

@Component({
  selector: 'app-category-list',
  standalone: true,
  imports: [CommonModule, NoDataComponent, RouterModule],
  templateUrl: './category-list.component.html'
})
export class CategoryListComponent {

  @Input()
  list:any

  @Output()
  onRemove = new EventEmitter<number>

  remove(id:number) {
    this.onRemove.emit(id)
  }

}
