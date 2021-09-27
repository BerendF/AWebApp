import {Component, OnInit} from '@angular/core';
import {Tutorial} from '../model/tutorial';
import {TutorialService} from '../service/tutorial-service.service';
import {NgbRatingConfig} from '@ng-bootstrap/ng-bootstrap';
import {Sort} from '@angular/material/sort';

@Component({
  selector: 'app-user-list',
  templateUrl: './tutorial-list.component.html',
  styleUrls: ['./tutorial-list.component.scss'],
  providers: [NgbRatingConfig]
})
export class TutorialListComponent implements OnInit {

  tutorials: Tutorial[] | undefined;
  sortedTut: Tutorial[] | undefined;

  constructor(private tutorialService: TutorialService, config: NgbRatingConfig) {
    config.max = 5;
    config.readonly = true;
  }

  ngOnInit() {
    this.tutorialService.findAll().subscribe((data: Tutorial[] | undefined) => {
      this.tutorials = data;
      this.sortedTut = data;
    });
  }

  convertStringToNumber(input: string | undefined) {

    if (!input) return NaN;

    if (input.length == 0) {
      return NaN;
    }
    return Number(input);
  }

  sortData(sort: Sort) {
    // @ts-ignore
    const data = this.tutorials.slice();
    if (!sort.active || sort.direction === '') {
      this.sortedTut = data;
      return;
    }

    this.sortedTut = data.sort((a, b) => {
      const isAsc = sort.direction === 'asc';
      switch (sort.active) {
        case 'title':
          return this.compare(a.title, b.title, isAsc);
        case 'rating':
          return this.compare(a.rating, b.rating, isAsc);
        case 'date':
          return this.compare(a.date, b.date, isAsc);
        default:
          return 0;
      }
    });
  }


  compare(a: undefined | string, b: undefined | string, isAsc: boolean) {
    // @ts-ignore
    return (a < b ? -1 : 1) * (isAsc ? 1 : -1);
  }
}
