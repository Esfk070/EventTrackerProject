import { last } from "rxjs";

export class Soldier {
  id: number;
  militaryRank: string;
  firstName: string;
  lastName: string;
  createDate: string | undefined;
  lastUpdate: string | undefined;
  imageUrl: string;
  enabled: boolean;
  profile: boolean;
  description: string;
  dod: number

  constructor(
    id: number=0,
    militaryRank: string = '',
    firstName: string = '',
    lastName: string = '',
    createDate: string = '',
    lastUpdate: string = '',
    imageUrl: string = '',
    enabled: boolean = false,
    profile: boolean = false,
    description: string = '',
    dod: number=0,
  )
  {
    this.id=id;
    this.militaryRank=militaryRank;
    this.firstName=firstName;
    this.lastName=lastName;
    this.createDate=createDate
    this.lastUpdate=lastUpdate;
    this.imageUrl=imageUrl;
    this.enabled=enabled;
    this.profile=profile;
    this.description=description;
    this.dod=dod;
  }

}
