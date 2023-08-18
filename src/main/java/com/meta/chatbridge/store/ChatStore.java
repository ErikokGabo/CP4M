/*
 *
 * Copyright (c) Meta Platforms, Inc. and affiliates.
 *
 * This source code is licensed under the MIT license found in the
 * LICENSE file in the root directory of this source tree.
 */

package com.meta.chatbridge.store;

import com.meta.chatbridge.message.Message;

/**
 * This class is in charge of both maintaining a chat history and managing a queue of conversations
 * that require a response.
 *
 * <p>Adding a message from {@link com.meta.chatbridge.message.Message.Role#USER} will indicate that
 * the conversation needs a response.
 *
 * @param <T> the type of message being passed
 */
public interface ChatStore<T extends Message> {

  MessageStack<T> add(T message);
}
