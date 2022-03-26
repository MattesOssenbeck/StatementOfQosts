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
public class Nachname extends WertObjekt<String>
{
	@Serial
	private static final long serialVersionUID = 2632717840087524114L;

	@NonNull
	@Column(name = "Nachname", nullable = false)
	private String wert;

	public static Validation<Meldung, Nachname> aus(String wert)
	{
		return validiereString(wert, Meldung.NACHNAME)
			.map(Nachname::new);
	}
}