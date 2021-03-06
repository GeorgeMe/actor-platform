package im.actor.core.api;
/*
 *  Generated by the Actor API Scheme generator.  DO NOT EDIT!
 */

import im.actor.runtime.bser.*;
import im.actor.runtime.collections.*;
import static im.actor.runtime.bser.Utils.*;
import im.actor.core.network.parser.*;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.NotNull;
import com.google.j2objc.annotations.ObjectiveCName;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

public class ApiSearchOrCondition extends ApiSearchCondition {

    private List<ApiSearchCondition> orQuery;

    public ApiSearchOrCondition(@NotNull List<ApiSearchCondition> orQuery) {
        this.orQuery = orQuery;
    }

    public ApiSearchOrCondition() {

    }

    public int getHeader() {
        return 4;
    }

    @NotNull
    public List<ApiSearchCondition> getOrQuery() {
        return this.orQuery;
    }

    @Override
    public void parse(BserValues values) throws IOException {
        this.orQuery = new ArrayList<ApiSearchCondition>();
        for (byte[] b : values.getRepeatedBytes(2)) {
            orQuery.add(ApiSearchCondition.fromBytes(b));
        }
    }

    @Override
    public void serialize(BserWriter writer) throws IOException {
        for (ApiSearchCondition i : this.orQuery) {
            writer.writeBytes(2, i.buildContainer());
        }
    }

    @Override
    public String toString() {
        String res = "struct SearchOrCondition{";
        res += "orQuery=" + this.orQuery;
        res += "}";
        return res;
    }

}
