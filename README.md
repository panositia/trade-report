# DAily Trade Report Engine

The instructions to compile and run the program are:

	cd trade-report
	mvn clean install
	java -jar trade-report-engine/target/trade-report-engine-1.0.0-jar-with-dependencies.jar

The output will be:

	Starting Daily Trade Report Engine version 1.0.0 on Mon Aug 13 02:22:58 EEST 2018
	Retrieving instructions...
	
	Entity                  | Buy/Sell      | AgreedFx      | Currency      | Instruction Date     | Settlement Date       | Units | Price Per Unit
	Dena Moran              | B             | 1,3922        | ASD           | 2018-08-05           | 2018-08-05            | 548   | $14.56
	Jeremy Cardenas         | B             | 1,0030        | EUR           | 2018-08-05           | 2018-08-06            | 516   | $18.98
	Barney Martinez         | B             | 1,1566        | SAR           | 2018-08-05           | 2018-08-05            | 169   | $69.50
	Alex Hanson             | B             | 1,0020        | SAR           | 2018-07-19           | 2018-07-19            | 764   | $90.69
	Stuart Marshall         | S             | 1,1725        | SAR           | 2018-08-11           | 2018-08-12            | 400   | $55.89
	Helga Caldwell          | B             | 0,5664        | SGP           | 2018-08-04           | 2018-08-04            | 105   | $71.62
	Jenna Leblanc           | S             | 1,4144        | ASD           | 2018-08-03           | 2018-08-03            | 956   | $74.27
	Marjorie Tran           | B             | 0,8143        | ASD           | 2018-08-12           | 2018-08-12            | 591   | $55.15
	Chance Leonard          | S             | 1,4116        | EUR           | 2018-07-16           | 2018-07-16            | 161   | $53.55
	Judy Schneider          | S             | 1,2517        | EUR           | 2018-07-31           | 2018-08-01            | 598   | $15.06
	
	Daily Incoming Amounts and Rankings:
	Amount in USD settled for 2018-07-16 is $12,169.88
	Ranking 1 is entity Chance Leonard with instruction amount $12,169.88
	Amount in USD settled for 2018-08-01 is $11,273.97
	Ranking 1 is entity Judy Schneider with instruction amount $11,273.97
	Amount in USD settled for 2018-08-03 is $100,419.89
	Ranking 1 is entity Jenna Leblanc with instruction amount $100,419.89
	Amount in USD settled for 2018-08-12 is $26,212.70
	Ranking 1 is entity Stuart Marshall with instruction amount $26,212.70
	
	Daily Outgoing Amounts and Rankings:
	Amount in USD settled for 2018-07-19 is $69,430.71
	Ranking 1 is entity Alex Hanson with instruction amount $69,430.71
	Amount in USD settled for 2018-08-05 is $13,585.39
	Ranking 1 is entity Barney Martinez with instruction amount $13,585.39
	Amount in USD settled for 2018-08-06 is $25,190.33
	Ranking 1 is entity Dena Moran with instruction amount $11,108.38
	Ranking 2 is entity Jeremy Cardenas with instruction amount $9,822.27
	Ranking 3 is entity Helga Caldwell with instruction amount $4,259.69
	Amount in USD settled for 2018-08-13 is $26,540.16
	Ranking 1 is entity Marjorie Tran with instruction amount $26,540.16
	
	End of Report data.
