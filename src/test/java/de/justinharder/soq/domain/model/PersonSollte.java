package de.justinharder.soq.domain.model;

import de.justinharder.Testdaten;
import de.justinharder.soq.domain.model.meldung.Meldung;
import de.justinharder.soq.domain.model.meldung.Meldungen;
import io.vavr.control.Validation;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("Person sollte")
class PersonSollte extends Testdaten
{
	private Person sut;

	private Validation<Meldungen, Person> validierung;

	@Test
	@DisplayName("invalide sein")
	void test01()
	{
		validierung = Person.aus(null, null);
		assertAll(
			() -> assertThrows(RuntimeException.class, validierung::get),
			() -> assertThat(validierung.getError()).containsExactlyInAnyOrder(Meldung.NACHNAME, Meldung.VORNAME));
	}

	@Test
	@DisplayName("valide sein")
	void test02()
	{
		validierung = Person.aus(HARDER, JUSTIN);
		sut = validierung.get();
		assertAll(
			() -> assertThrows(RuntimeException.class, validierung::getError),
			() -> assertThat(sut.getNachname()).isEqualTo(HARDER),
			() -> assertThat(sut.getVorname()).isEqualTo(JUSTIN));

		validierung = Person.aus(TIEMERDING, LAURA);
		sut = validierung.get();
		assertAll(
			() -> assertThrows(RuntimeException.class, validierung::getError),
			() -> assertThat(sut.getNachname()).isEqualTo(TIEMERDING),
			() -> assertThat(sut.getVorname()).isEqualTo(LAURA));
	}

	@Test
	@DisplayName("sich drucken")
	void test03()
	{
		assertThat(Person.aus(HARDER, JUSTIN).get()).hasToString("Person{Nachname=Harder, Vorname=Justin}");
	}
}