package de.justinharder.soq.domain.model.attribute;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

public abstract class WertObjekt<T> implements Serializable, Comparable<WertObjekt<T>>
{
	@Serial
	private static final long serialVersionUID = -3153085157460251690L;

	public abstract T getWert();

	@Override
	@SuppressWarnings("unchecked")
	public boolean equals(Object o)
	{
		if (this == o)
		{
			return true;
		}
		if (o == null || getClass() != o.getClass())
		{
			return false;
		}
		WertObjekt<T> that = (WertObjekt<T>) o;
		return Objects.equals(getWert(), that.getWert());
	}

	@Override
	public int hashCode()
	{
		return Objects.hashCode(getWert());
	}

	@Override
	@SuppressWarnings("unchecked")
	public int compareTo(WertObjekt<T> o)
	{
		return ((Comparable<T>) getWert()).compareTo(o.getWert());
	}

	@Override
	public String toString()
	{
		return getWert().toString();
	}
}
