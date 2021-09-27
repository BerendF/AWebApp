import {Component} from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {TutorialService} from '../service/tutorial-service.service';
import {Tutorial} from '../model/tutorial';
import {Wiki} from "../model/wiki";
import {WikiServiceService} from "../service/wiki-service.service";

@Component({
  selector: 'app-user-form',
  templateUrl: './tutorial-form.component.html',
  styleUrls: ['./tutorial-form.component.scss']
})
export class TutorialFormComponent {

  user: Tutorial
  wiki: Wiki;
  today = new Date();
  dd = String(this.today.getDate()).padStart(2, '0');
  mm = String(this.today.getMonth() + 1).padStart(2, '0'); //January is 0!
  yyyy = this.today.getFullYear();

  date = this.dd + "." + this.mm + "." + this.yyyy;


  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private tutorialService: TutorialService,
    private wikiService: WikiServiceService) {
    this.user = new Tutorial();
    this.wiki = new Wiki();
  }

  onSubmit() {
    this.user.date = this.date;
    this.tutorialService.save(this.user).subscribe(result => this.gotoUserList());
  }

  onWikiSubmit() {
    this.wikiService.save(this.wiki).subscribe(result => this.gotoWikiList())
  }

  gotoUserList() {
    this.router.navigate(['/tutorials']);
  }

  gotoWikiList() {
    this.router.navigate(['/wiki'])
  }
}
