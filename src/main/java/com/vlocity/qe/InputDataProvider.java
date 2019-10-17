package com.vlocity.qe;

import org.testng.annotations.DataProvider;

public class InputDataProvider {

	@DataProvider(name = "Languages")
	public String[][] getData() {
		String[][] languages=new String[10][2];
		languages[0][0]="js-link-box-en";
		languages[0][1]="English";
		languages[1][0]="js-link-box-es";
		languages[1][1]="Español";
		languages[2][0]="js-link-box-de";
		languages[2][1]="Deutsch";
		languages[3][0]="js-link-box-fr";
		languages[3][1]="Français";
		languages[4][0]="js-link-box-zh";
		languages[4][1]="中文";
		languages[5][0]="js-link-box-pl";
		languages[5][1]="Polski";
		languages[6][0]="js-link-box-pt";
		languages[6][1]="Português";
		languages[7][0]="js-link-box-it";
		languages[7][1]="Italiano";
		languages[8][0]="js-link-box-ru";
		languages[8][1]="Русский";
		languages[9][0]="js-link-box-ja";
		languages[9][1]="日本語";
		return languages;
	}
}
