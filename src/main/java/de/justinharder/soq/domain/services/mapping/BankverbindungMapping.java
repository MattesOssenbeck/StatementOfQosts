package de.justinharder.soq.domain.services.mapping;

import de.justinharder.soq.domain.model.Bankverbindung;
import de.justinharder.soq.domain.services.dto.GespeicherteBankverbindung;
import lombok.NonNull;

import javax.enterprise.context.Dependent;

@Dependent
public class BankverbindungMapping implements Mapping<Bankverbindung, GespeicherteBankverbindung>
{
	@Override
	public GespeicherteBankverbindung mappe(@NonNull Bankverbindung bankverbindung)
	{
		// TODO: Benutzer und Bank müssen mitgegeben werden.
		return new GespeicherteBankverbindung(
			bankverbindung.getId().getWert().toString(),
			bankverbindung.getIban().getWert(),
			"",
			"",
			"");
	}
}
