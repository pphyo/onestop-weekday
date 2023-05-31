import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { UsingObservableChildComponent } from './using-observable-child/using-observable-child.component';
import { Subject } from 'rxjs';

@Component({
  selector: 'app-using-observable',
  standalone: true,
  imports: [CommonModule, UsingObservableChildComponent],
  templateUrl: './using-observable.component.html'
})
export class UsingObservableComponent implements OnInit {
  list:any = []

  subject = new Subject<string>

  ngOnInit(): void {
    this.subject.subscribe(data => this.list.push(data))
  }

}
