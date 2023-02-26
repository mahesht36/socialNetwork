package socialNetwork.supportingSteps;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class Simulation {

    private int userId;
    private String title;
    private String postBody;

    private String postId;
    private String name;
    private String email;
    private String commentBody;

}
