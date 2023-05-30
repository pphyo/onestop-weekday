import { AfterContentChecked, AfterContentInit, AfterViewChecked, AfterViewInit, Component, DoCheck, OnChanges, OnDestroy, OnInit, SimpleChanges } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styles: []
})
export class AppComponent implements
OnChanges,
OnInit,
DoCheck,
AfterContentInit,
AfterContentChecked,
AfterViewInit,
AfterViewChecked,
OnDestroy {

  title = 'The Component'

  parentCount:number = 0

  constructor() {
    this.log('Constructor')
  }

  ngOnChanges(changes: SimpleChanges): void {
    this.log('ngOnChanges')
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
    console.log(`Parent ${message}`);
  }

  countUp() {
    this.parentCount ++
  }
}
