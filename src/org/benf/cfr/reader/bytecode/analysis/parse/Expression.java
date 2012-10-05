package org.benf.cfr.reader.bytecode.analysis.parse;

import org.benf.cfr.reader.bytecode.analysis.parse.utils.*;
import org.benf.cfr.reader.bytecode.analysis.types.discovery.InferredJavaType;
import org.benf.cfr.reader.entities.GenericInfoSource;

/**
 * Created by IntelliJ IDEA.
 * User: lee
 * Date: 15/03/2012
 */
public interface Expression {
    // Can /PROBABLY/ replace LValueRewriter with expression rewriter.
    Expression replaceSingleUsageLValues(LValueRewriter lValueRewriter, SSAIdentifiers ssaIdentifiers, StatementContainer statementContainer);

    Expression applyExpressionRewriter(ExpressionRewriter expressionRewriter, SSAIdentifiers ssaIdentifiers, StatementContainer statementContainer, ExpressionRewriterFlags flags);

    boolean isSimple();

    void collectUsedLValues(LValueUsageCollector lValueUsageCollector);

    boolean canPushDownInto();

    Expression pushDown(Expression toPush, Expression parent);

    InferredJavaType getInferredJavaType();

    void findGenericTypeInfo(GenericInfoSource genericInfoSource);
}
