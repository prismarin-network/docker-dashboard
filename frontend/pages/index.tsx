import {observer} from "mobx-react-lite";
import DefaultLayout from "../layouts/DefaultLayout";

const IndexPage = observer(() => {

    return (
        <DefaultLayout>
            <h1>
                Test
            </h1>
        </DefaultLayout>
    )
})

export default IndexPage
