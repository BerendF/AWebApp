import {Component, OnInit} from '@angular/core';
import {Sort} from "@angular/material/sort";
import {Wiki} from "../model/wiki";
import {WikiServiceService} from "../service/wiki-service.service";

@Component({
  selector: 'app-wikis',
  templateUrl: './wikis.component.html',
  styleUrls: ['./wikis.component.scss']
})
export class WikisComponent implements OnInit {

  wikis: Wiki[] | undefined;
  sortedWikis: Wiki[] | undefined;

  constructor(private wikiService: WikiServiceService) {
  }

  ngOnInit(): void {
    this.wikiService.findAll().subscribe((data: Wiki[] | undefined) => {
      this.wikis = data;
      this.sortedWikis = data;
    });
  }

  sortData(sort: Sort) {
    // @ts-ignore
    const data = this.wikis.slice();
    if (!sort.active || sort.direction === '') {
      this.sortedWikis = data;
      return;
    }

    this.sortedWikis = data.sort((a, b) => {
      const isAsc = sort.direction === 'asc';
      if (sort.active == 'name') {
        return this.compare(a.name, b.name, isAsc);
      } else {
        return 0;
      }
    });
  }

  compare(a: undefined | string, b: undefined | string, isAsc: boolean) {
    // @ts-ignore
    return (a < b ? -1 : 1) * (isAsc ? 1 : -1);
  }
}
