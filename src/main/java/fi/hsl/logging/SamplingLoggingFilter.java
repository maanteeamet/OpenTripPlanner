package fi.hsl.logging;
import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.filter.Filter;
import ch.qos.logback.core.spi.FilterReply;

public class SamplingLoggingFilter extends Filter<ILoggingEvent> {

    private int c = 0;
    @Override
    public FilterReply decide(ILoggingEvent event) {
        if(event.getLevel()==Level.ERROR || event.getLevel()==Level.WARN || event.getLevel()==Level.INFO) {
            if(c++%10==0) {
                return FilterReply.ACCEPT;
            } else {        
                return FilterReply.DENY;                
            }
        } 
        return FilterReply.DENY;
    }

}