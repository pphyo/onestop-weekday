import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { CommonModule } from '@angular/common';
import { NoDataComponent } from '../../no-data/no-data.component';
import { RouterModule } from '@angular/router';
import { ConfirmComponent } from '../../confirm/confirm.component';

declare var bootstrap:any

@Component({
  selector: 'app-category-list',
  standalone: true,
  imports: [CommonModule, NoDataComponent, ConfirmComponent, RouterModule],
  templateUrl: './category-list.component.html'
})
export class CategoryListComponent implements OnInit {

  confirmModal:any
  removeId:any

  @Input()
  list:any

  @Output()
  onRemove = new EventEmitter<number>

  ngOnInit(): void {
    this.confirmModal = new bootstrap.Modal('#confirm',
      {backdrop: false})
  }

  remove(id:number) {
    this.confirmModal.show()
    this.removeId = id
  }

  confirmRemove(id:any) {
    if(id)
      this.onRemove.emit(id)

    this.confirmModal.hide()
  }

}
