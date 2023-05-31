import { Component, Input, OnChanges, SimpleChanges } from '@angular/core';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-input-child',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './input-child.component.html'
})
export class InputChildComponent implements OnChanges {
  @Input("childCourse")
  course:any

  ngOnChanges(changes: SimpleChanges): void {
    console.log(this.course)
    console.log('changes')
  }

}
