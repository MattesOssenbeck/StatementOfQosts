package de.justinharder.soq.view;

import de.justinharder.soq.domain.services.BankverbindungService;
import de.justinharder.soq.domain.services.BenutzerService;
import de.justinharder.soq.domain.services.KontoinhaberService;
import de.justinharder.soq.domain.services.dto.NeuerKontoinhaber;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;

@DisplayName("KontoinhaberRessource sollte")
class KontoinhaberRessourceSollte
{
	private KontoinhaberService kontoinhaberService;
	private BenutzerService benutzerService;
	private BankverbindungService bankverbindungService;
	private NeuerKontoinhaber neuerKontoinhaber;

	@BeforeEach
	void setup()
	{
		kontoinhaberService = mock(KontoinhaberService.class);
		benutzerService = mock(BenutzerService.class);
		bankverbindungService = mock(BankverbindungService.class);
		neuerKontoinhaber = mock(NeuerKontoinhaber.class);
	}

	@Test
	@DisplayName("null validieren")
	void test01()
	{
		assertAll(
			() -> assertThrows(NullPointerException.class,
				() -> new KontoinhaberRessource(null, benutzerService, bankverbindungService, neuerKontoinhaber)),
			() -> assertThrows(NullPointerException.class,
				() -> new KontoinhaberRessource(kontoinhaberService, null, bankverbindungService, neuerKontoinhaber)),
			() -> assertThrows(NullPointerException.class,
				() -> new KontoinhaberRessource(kontoinhaberService, benutzerService, null, neuerKontoinhaber)),
			() -> assertThrows(NullPointerException.class,
				() -> new KontoinhaberRessource(kontoinhaberService, benutzerService, bankverbindungService, null)));
	}
}
