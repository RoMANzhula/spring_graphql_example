package org.romanzhula.spring_graphql_example.exceptions;

import graphql.GraphQLError;
import graphql.GraphqlErrorBuilder;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.graphql.execution.DataFetcherExceptionResolverAdapter;
import org.springframework.graphql.execution.ErrorType;
import org.springframework.stereotype.Component;

@Component
public class CastExceptionHandler extends DataFetcherExceptionResolverAdapter {
    @Override
    protected GraphQLError resolveToSingleError(Throwable ex, DataFetchingEnvironment env) {
        ErrorType currentType = null;

        if (ex instanceof DataIntegrityViolationException) {
            currentType = ErrorType.BAD_REQUEST;
        } else {
            currentType = ErrorType.INTERNAL_ERROR;
        }

        return GraphqlErrorBuilder
                .newError(env)
                .message("Received message: " + ex.getMessage())
                .errorType(currentType)
                .build()
        ;
    }
}
