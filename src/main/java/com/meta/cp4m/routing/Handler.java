/*
 *
 * Copyright (c) Meta Platforms, Inc. and affiliates.
 *
 * This source code is licensed under the MIT license found in the
 * LICENSE file in the root directory of this source tree.
 */

package com.meta.cp4m.routing;

import io.javalin.http.Context;

@FunctionalInterface
public interface Handler<I> {

  void handle(Context ctx, I input);
}
