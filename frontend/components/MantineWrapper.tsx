import {ReactNode} from "react";
import {MantineProvider} from '@mantine/core';
import {ModalsProvider} from '@mantine/modals';
import {NotificationsProvider} from "@mantine/notifications";
import {useColorScheme} from "@mantine/hooks";

const MantineWrapper = ({children}: { children: ReactNode }) => {
    const preferredColorScheme = useColorScheme();

    return (
        <MantineProvider theme={{colorScheme: preferredColorScheme, primaryColor: "cyan"}}>
            <NotificationsProvider limit={5} autoClose={5000} position="top-right">
                <ModalsProvider>
                    {children}
                </ModalsProvider>
            </NotificationsProvider>
        </MantineProvider>
    )
}

export default MantineWrapper
