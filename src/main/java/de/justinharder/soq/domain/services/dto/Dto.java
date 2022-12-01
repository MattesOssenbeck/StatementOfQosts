package de.justinharder.soq.domain.services.dto;

import de.justinharder.soq.domain.model.meldung.Ebene;
import de.justinharder.soq.domain.model.meldung.Meldung;
import de.justinharder.soq.domain.model.meldung.Meldungen;
import de.justinharder.soq.domain.model.meldung.Schluessel;
import lombok.NonNull;

import java.util.List;

public abstract class Dto<T extends Dto<T>>
{
	private final Meldungen meldungen = new Meldungen();

	protected abstract T myself();

	public boolean istErfolgreich()
	{
		return meldungen.stream().allMatch(meldung -> meldung.ebene().equals(Ebene.ERFOLG));
	}

	public T fuegeMeldungHinzu(@NonNull Meldung meldung)
	{
		meldungen.add(meldung);
		return myself();
	}

	public T fuegeMeldungenHinzu(@NonNull Meldungen meldungen)
	{
		this.meldungen.addAll(meldungen);
		return myself();
	}

	public boolean hatMeldungen()
	{
		return !meldungen.isEmpty();
	}

	public List<Meldung> getMeldungen(Schluessel schluessel)
	{
		return meldungen.stream()
			.filter(meldung -> meldung.schluessel().equals(schluessel))
			.toList();
	}

	public boolean hatMeldungen(Schluessel schluessel)
	{
		return !getMeldungen(schluessel).isEmpty();
	}
}