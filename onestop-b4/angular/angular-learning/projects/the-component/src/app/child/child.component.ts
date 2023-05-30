import { AfterContentChecked, AfterContentInit, AfterViewChecked, AfterViewInit, Component, DoCheck, Input, OnChanges, OnDestroy, OnInit, SimpleChanges } from "@angular/core";

@Component({
  selector: 'app-child',
  template: `
    Count: {{ childCount }}
  `
})
export class ChildComponent implements
OnChanges,
OnInit,
DoCheck,
AfterContentInit,
AfterContentChecked,
AfterViewInit,
AfterViewChecked,
OnDestroy {

  @Input()
  childCount:number = 0

  constructor() {
    this.log('Constructor')
  }

  ngOnChanges(changes: SimpleChanges): void {
    this.log('ngOnChanges')
    console.log(changes)
  }

  ngOnInit(): void {
    this.log('ngOnInit')
  }

  ngDoCheck(): void {
    this.log('ngDoCheck')
  }

  ngAfterContentInit(): void {
    this.log('ngAfterContentInit')
  }

  ngAfterContentChecked(): void {
    this.log('ngAfterContentChecked')
  }

  ngAfterViewInit(): void {
    this.log('ngAfterViewInit')
  }

  ngAfterViewChecked(): void {
    this.log('ngAfterViewChecked')
  }

  ngOnDestroy(): void {
    this.log('ngOnDestroy')
  }

  private log(message:string) {
    console.log(`Child ${message}`);
  }

}
