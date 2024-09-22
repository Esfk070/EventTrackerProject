import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'acftHigh',
  standalone: true
})
export class AcftHighPipe implements PipeTransform {

  transform(value: unknown, ...args: unknown[]): unknown {
    return null;
  }

}
