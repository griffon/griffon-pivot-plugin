/*
 * Copyright 2012 the original author or authors.
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

package griffon.pivot.support.adapters;

import groovy.lang.Closure;

/**
 * @author Andres Almiray
 */
public class TextInputSelectionAdapter implements GriffonPivotAdapter, org.apache.pivot.wtk.TextInputSelectionListener {
    private Closure selectionChanged;

    public Closure getSelectionChanged() {
        return this.selectionChanged;
    }


    public void setSelectionChanged(Closure selectionChanged) {
        this.selectionChanged = selectionChanged;
        if (this.selectionChanged != null) {
            this.selectionChanged.setDelegate(this);
            this.selectionChanged.setResolveStrategy(Closure.DELEGATE_FIRST);
        }
    }


    public void selectionChanged(org.apache.pivot.wtk.TextInput arg0, int arg1, int arg2) {
        if (selectionChanged != null) {
            selectionChanged.call(arg0, arg1, arg2);
        }
    }

}
