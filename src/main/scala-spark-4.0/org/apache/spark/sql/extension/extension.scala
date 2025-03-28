/*
 * Copyright 2024 G-Research
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.spark.sql

import org.apache.spark.sql.catalyst.expressions.Expression
import org.apache.spark.sql.classic.ExpressionUtils.{column => toColumn, expression}

package object extension {
  implicit class ColumnExtension(col: Column) {
    def expr: Expression = expression(col)
    def sql: String = col.node.sql
  }

  implicit class ExpressionExtension(expr: Expression) {
    def column: Column = toColumn(expr)
  }
}
