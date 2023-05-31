import { Pipe, PipeTransform } from '@angular/core';

const SUBJECT:ReadonlyArray<string> = ['HTML', 'CSS', 'JS', 'Angular']

@Pipe({
  name: 'subject',
  standalone: true
})
export class SubjectPipe implements PipeTransform {

  transform(value: []): unknown {
    return SUBJECT.filter((_, index) => value[index]);
  }

}
