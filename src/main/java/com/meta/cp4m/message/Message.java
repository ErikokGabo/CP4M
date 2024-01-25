/*
 *
 * Copyright (c) Meta Platforms, Inc. and affiliates.
 *
 * This source code is licensed under the MIT license found in the
 * LICENSE file in the root directory of this source tree.
 */

package com.meta.cp4m.message;

import com.meta.cp4m.Identifier;
import org.checkerframework.checker.lock.qual.NewObject;
import org.checkerframework.checker.nullness.qual.Nullable;

import java.time.Instant;

public interface Message {
  private static Identifier threadId(Identifier id1, Identifier id2) {
    if (id1.compareTo(id2) <= 0) {
      return Identifier.from(id1.toString() + '|' + id2);
    }
    return Identifier.from(id2.toString() + '|' + id1);
  }

  public <T extends Message> @NewObject T withParentMessage(Message parentMessage);

  Instant timestamp();

  Identifier instanceId();

  Identifier senderId();

  Identifier recipientId();

  String message();

  Role role();

  @Nullable Message parentMessage();

  default Identifier threadId() {
    return threadId(senderId(), recipientId());
  }

  enum Role {
    ASSISTANT(0),
    USER(1),
    SYSTEM(2);

    private final int priority;

    private Role(Integer priority){
      this.priority = priority;
    }

    public int getPriority(){
      return this.priority;
    }

  }
}
