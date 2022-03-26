package de.justinharder.soq.domain.model.attribute;

import de.justinharder.soq.domain.model.meldung.Meldung;
import io.vavr.control.Validation;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serial;

@Getter
@Embeddable
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class Benutzername extends WertObjekt<String>
{
	@Serial
	private static final long serialVersionUID = 565018202070781652L;

	@NonNull
	@Column(name = "Benutzername", nullable = false)
	private String wert;

	public static Validation<Meldung, Benutzername> aus(String wert)
	{
		return validiereString(wert, Meldung.BENUTZERNAME)
			.map(Benutzername::new);
	}
}