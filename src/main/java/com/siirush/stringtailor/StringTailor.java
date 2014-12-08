package com.siirush.stringtailor;

import com.siirush.stringtailor.model.Evaluatable;
import com.siirush.stringtailor.model.EvaluatableStatement;

public interface StringTailor {
	StringTailor add(Evaluatable ... components);
	StringTailor optional(Evaluatable ... components);
	EvaluatableStatement done();
}
