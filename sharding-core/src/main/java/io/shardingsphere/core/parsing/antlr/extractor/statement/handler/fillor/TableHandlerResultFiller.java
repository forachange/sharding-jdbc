/*
 * Copyright 2016-2018 shardingsphere.io.
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * </p>
 */

package io.shardingsphere.core.parsing.antlr.extractor.statement.handler.fillor;

import io.shardingsphere.core.parsing.antlr.extractor.statement.handler.result.ExtractResult;
import io.shardingsphere.core.parsing.antlr.extractor.statement.handler.result.TableExtractResult;
import io.shardingsphere.core.parsing.parser.context.table.Table;
import io.shardingsphere.core.parsing.parser.sql.SQLStatement;

/**
 * Table handler result filler.
 *
 * @author duhongjun
 */
public class TableHandlerResultFiller extends AbstractHandlerResultFiller {

    public TableHandlerResultFiller(final Class<? extends ExtractResult> extractResultClass) {
        super(TableExtractResult.class);
    }

    public TableHandlerResultFiller() {
        super(TableExtractResult.class);
    }

    /**
     * Fill result to SQLStatement.
     *
     * @param extractResult extract result from AST
     * @param statement SQL statement
     */
    @Override
    protected void fillSQLStatement(final Object extractResult, final SQLStatement statement) {
        TableExtractResult tableResult = (TableExtractResult) extractResult;
        statement.getTables().add(new Table(tableResult.getName(), tableResult.getAlias()));
        statement.getSQLTokens().add(tableResult.getToken());
    }
}
