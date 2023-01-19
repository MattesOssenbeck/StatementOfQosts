package de.justinharder.soq.persistence;

import de.justinharder.soq.IntegrationTest;
import de.justinharder.soq.domain.model.attribute.Bezeichnung;
import de.justinharder.soq.domain.model.attribute.ID;
import de.justinharder.soq.domain.model.meldung.Schluessel;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;
import javax.transaction.Transactional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertThrows;

@QuarkusTest
@DisplayName("KategorieJpaRepository sollte")
public class KategorieJpaRepositorySollte extends IntegrationTest
{
	@Inject
	KategorieJpaRepository sut;

	@Test
	@DisplayName("null validieren")
	void test01()
	{
		assertAll(
			() -> assertThrows(NullPointerException.class, () -> sut.finde((ID) null)),
			() -> assertThrows(NullPointerException.class, () -> sut.speichere(null)),
			() -> assertThrows(NullPointerException.class, () -> sut.loesche(null)),
			() -> assertThrows(NullPointerException.class, () -> sut.finde((Bezeichnung) null)),
			() -> assertThrows(NullPointerException.class, () -> sut.istVorhanden(null)));
	}

	@Test
	@DisplayName("alle finden")
	void test02()
	{
		assertThat(sut.findeAlle()).containsExactlyInAnyOrder(kategorie1, kategorie2);
	}

	@Test
	@DisplayName("finden")
	void test03()
	{
		assertAll(
			() -> assertThat(sut.finde(kategorie1.getId())).contains(kategorie1),
			() -> assertThat(sut.finde(kategorie2.getId())).contains(kategorie2),
			() -> assertThat(sut.finde(ID.aus("f22396bf-a21b-4b0b-b5c2-798b130a24c1", Schluessel.KATEGORIE).get()))
				.isEmpty(),
			() -> assertThat(sut.finde(kategorie1.getBezeichnung())).contains(kategorie1),
			() -> assertThat(sut.finde(Bezeichnung.aus("Tanken").get())).isEmpty(),
			() -> assertThat(sut.istVorhanden(kategorie1.getBezeichnung())).isTrue(),
			() -> assertThat(sut.istVorhanden(Bezeichnung.aus("Tanken").get())).isFalse());
	}

	@Test
	@Transactional
	@DisplayName("speichern")
	@Disabled("Wenn gespeichert wird, funktioniert ein ViewTest nicht mehr")
	void test04()
	{}

	@Test
	@Transactional
	@DisplayName("löschen")
	@Disabled("Wenn gelöscht wird, funktioniert ein ViewTest nicht mehr")
	void test05()
	{}
}
