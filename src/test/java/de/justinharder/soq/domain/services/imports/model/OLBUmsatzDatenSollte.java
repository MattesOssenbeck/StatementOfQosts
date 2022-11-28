package de.justinharder.soq.domain.services.imports.model;

import de.justinharder.Testdaten;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("OLBUmsatzDaten sollte")
class OLBUmsatzDatenSollte extends Testdaten
{
	@Test
	@DisplayName("sich drucken")
	void test01()
	{
		assertThat(OLB_UMSATZ_DATEN).hasToString(
			"OLBUmsatzDaten{Inhaberkonto=DE87280200504008357800, Buchungsdatum=31.10.2022, Valuta=31.10.2022, Auftraggeber=Laura Tiemerding, IBAN=DE28280651080012888000, BIC=GENODEF1DIK, Verwendungszweck=Wohnungsmiete, Betrag=447,48, Waehrung=EUR, Kundenreferenzen=NONREF, Bankreferenz=, Primatnota=0004770, TransaktionsCode=152, TransaktionsText=DA-GUTSCHR}");
	}
}
