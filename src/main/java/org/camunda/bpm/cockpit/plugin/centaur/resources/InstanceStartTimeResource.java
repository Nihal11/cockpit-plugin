package org.camunda.bpm.cockpit.plugin.centaur.resources;

import org.camunda.bpm.cockpit.db.QueryParameters;
import org.camunda.bpm.cockpit.plugin.resource.AbstractCockpitPluginResource;
import org.camunda.bpm.cockpit.plugin.centaur.db.InstanceStartTimeDto;

import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

public class InstanceStartTimeResource extends AbstractCockpitPluginResource {

    public InstanceStartTimeResource(String engineName) {
        super(engineName);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<InstanceStartTimeDto> InstanceStartTime() {
        QueryParameters<InstanceStartTimeDto> queryParameters = new QueryParameters<>();

        configureTenantCheck(queryParameters);

        return getQueryService().executeQuery(
                "cockpit.query.selectInstanceStartTime", queryParameters);
    }
}
